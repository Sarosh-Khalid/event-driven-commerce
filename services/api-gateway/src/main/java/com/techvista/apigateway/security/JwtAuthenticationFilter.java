package com.techvista.apigateway.security;


import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter
        implements GlobalFilter, Ordered {


    private final JwtService jwtService;



    @Override
    public reactor.core.publisher.Mono<Void> filter(
            org.springframework.web.server.ServerWebExchange exchange,
            org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {


        String path =
                exchange.getRequest()
                        .getURI()
                        .getPath();



        // allow login/register
        if(path.contains("/auth")){
            return chain.filter(exchange);
        }


        String header =
                exchange.getRequest()
                        .getHeaders()
                        .getFirst(HttpHeaders.AUTHORIZATION);



        if(header == null ||
                !header.startsWith("Bearer ")) {


            exchange.getResponse()
                    .setStatusCode(
                            HttpStatus.UNAUTHORIZED
                    );


            return exchange.getResponse()
                    .setComplete();
        }


        String token =
                header.substring(7);



        if(!jwtService.validate(token)){


            exchange.getResponse()
                    .setStatusCode(
                            HttpStatus.UNAUTHORIZED
                    );


            return exchange.getResponse()
                    .setComplete();

        }


        return chain.filter(exchange);

    }


    @Override
    public int getOrder() {
        return -1;
    }
}