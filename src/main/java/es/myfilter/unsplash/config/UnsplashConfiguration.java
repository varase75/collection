package es.myfilter.unsplash.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;

@Configuration
public class UnsplashConfiguration {

    @Bean
    public OAuth2RestTemplate unsplashRestTemplate(ClientCredentialsResourceDetails unsplashClientCredentialsResourceDetails, HttpComponentsClientHttpRequestFactory unsplashRequestFactory) {
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(unsplashClientCredentialsResourceDetails);

//        ClientCredentialsAccessTokenProvider clientCredentialsAccessTokenProvider = new ClientCredentialsAccessTokenProvider();
//        clientCredentialsAccessTokenProvider.setRequestFactory(unsplashRequestFactory);
//        AccessTokenProvider accessTokenProvider = new AccessTokenProviderChain(Collections.<AccessTokenProvider>singletonList(clientCredentialsAccessTokenProvider));
//
//        restTemplate.setRequestFactory(unsplashRequestFactory);
//        restTemplate.setAccessTokenProvider(accessTokenProvider);

        restTemplate.getOAuth2ClientContext().setAccessToken(new OAuth2AccessToken() {
			
			@Override
			public boolean isExpired() {
				return false;
			}
			
			@Override
			public String getValue() {
				return "Cns0MGThXWeoIUagKeR1PH-at2u64XQWF56-JsVCPoU";
			}
			
			@Override
			public String getTokenType() {
				return "Bearer";
			}
			
			@Override
			public Set<String> getScope() {
				return null;
			}
			
			@Override
			public OAuth2RefreshToken getRefreshToken() {
				return null;
			}
			
			@Override
			public int getExpiresIn() {
				return Integer.MAX_VALUE;
			}
			
			@Override
			public Date getExpiration() {
				return null;
			}
			
			@Override
			public Map<String, Object> getAdditionalInformation() {
				return null;
			}
		});

        return restTemplate;
    }

    @Bean
    HttpComponentsClientHttpRequestFactory unsplashRequestFactory(@Value("${my-filter.unsplash-connector.timeout.connection-timeout}") Integer connectionTimeout,
                                                            @Value("${my-filter.unsplash-connector.timeout.socket-timeout}") Integer socketTimeout) {
        RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(connectionTimeout)
            .setConnectionRequestTimeout(connectionTimeout)
            .setSocketTimeout(socketTimeout)
            .build();

        HttpClientBuilder httpClientBuilder = HttpClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .setDefaultHeaders(Arrays.asList(new BasicHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE),
                                             new BasicHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)));

        return new HttpComponentsClientHttpRequestFactory(httpClientBuilder.build());
    }

    @Bean
    ClientCredentialsResourceDetails unsplashClientCredentialsResourceDetails(@Value("${my-filter.unsplash-connector.security.oauth2.client.client-id}") String clientId,
                                                                        @Value("${my-filter.unsplash-connector.security.oauth2.client.client-secret}") String clientSecret,
                                                                        @Value("${my-filter.unsplash-connector.security.oauth2.client.access-token-uri}") String accessTokenUri,
                                                                        @Value("${my-filter.unsplash-connector.security.oauth2.client.scope}") String scope,
                                                                        @Value("${my-filter.unsplash-connector.security.oauth2.client.grant-type}") String grantType) {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setScope(Collections.singletonList(scope));
        details.setGrantType(grantType);

        return details;
    }

}