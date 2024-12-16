package ml.authentication.configs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ml.authentication.configs.data.SecretData;
import ml.authentication.util.ProfileConstants;
import ml.authentication.util.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@Configuration
public class SecretManager {


    @Autowired
    private SecurityConstants securityConstants;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    @Profile(ProfileConstants.NOT_LOCAL)
    public SecretData getSecret() throws JsonProcessingException {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> not local 1");
        Region region = Region.of(Region.US_EAST_2.toString());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> not local 2");
        SecretsManagerClient client = SecretsManagerClient.builder()
                .region(region)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> not local 3");
        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(securityConstants.getSecretArn())
                .build();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> not local 4");
        GetSecretValueResponse getSecretValueResult = client.getSecretValue(getSecretValueRequest);
        String secret = getSecretValueResult.secretString();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> not local 5");
        System.out.println(secret);

        return this.objectMapper.readValue(secret, SecretData.class);

    }

    @Bean
    @Profile(ProfileConstants.LOCAL)
    public SecretData getSecretLocal() throws JsonProcessingException {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> local");
        SecretData secretData = new SecretData();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> local");
        secretData.setSecret(securityConstants.getLocalSecret());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> local");
        System.out.println(secretData);

        return secretData;

    }

}
