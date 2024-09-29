package br.com.fiap.gerenciamentotrafego.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Gerenciamento de Trafego API")
                        .description("A API de Gerenciamento de Incidentes de Tráfego foi desenvolvida com Java e Spring, oferecendo soluções para o gerenciamento de acidentes de trânsito, usuários e autenticação. Com endpoints públicos e privados, permite o registro detalhado de acidentes, incluindo veículos, localização, data, hora, gravidade e feridos, armazenando os dados validados em um banco MongoDB. Foi implementado um workflow de Integração Contínua (CI) utilizando GitHub Actions para testes e builds em pull requests, e um processo de Entrega Contínua (CD) que realiza o deploy automático da aplicação em produção. A aplicação é containerizada com Docker e implantada na Azure, garantindo atualizações rápidas e escalabilidade.")
                        .contact(new Contact()
                                .name("Vinicius Leonel")
                                .email("viniciuslps.cms@gmail.com")));
//                        .license(new License()
//                                .name("Apache 2.0")
//                                .url("http://example.url.br/api/licenca")));
    }
}