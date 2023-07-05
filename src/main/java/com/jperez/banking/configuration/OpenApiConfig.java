package com.jperez.banking.configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@SecurityScheme(name = "jwt", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPIConfig() {
        Schema<?> mapSchema = new Schema<Map<String, String>>()
                .addProperty(Constants.RESPONSE_MESSAGE, new StringSchema().example("string"));
        Schema<?> errorSchema = new Schema<Map<String, String>>()
                .addProperty(Constants.ERROR_MESSAGE, new StringSchema().example("string"));

        Server devServer = new Server();
        devServer.setUrl(Constants.SERVER_DEV_URL);
        devServer.setDescription(Constants.SERVER_DEV_DESCRIPTION);

        Contact contact = new Contact();
        contact.setName(Constants.CONTACT_NAME);
        contact.setEmail(Constants.CONTACT_EMAIL);
        contact.setUrl(Constants.CONTACT_URL_WEBSITE);

        License license = new License()
                .name(Constants.LICENSE_NAME)
                .url(Constants.LICENSE_URL);

        Info info = new Info()
                .title(Constants.SWAGGER_TITLE)
                .version(Constants.SWAGGER_VERSION)
                .contact(contact)
                .description(Constants.SWAGGER_DESCRIPTION)
                .license(license)
                .termsOfService(Constants.SWAGGER_TERMS_OF_SERVICE);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer))
                .components(new Components()
                        .addSchemas("Map", mapSchema)
                        .addSchemas("Error", errorSchema));
    }

}
