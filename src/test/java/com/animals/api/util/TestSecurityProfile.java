package com.animals.api.util;

import io.quarkus.test.junit.QuarkusTestProfile;
import java.util.Map;

public class TestSecurityProfile implements QuarkusTestProfile {
    @Override
    public Map<String, String> getConfigOverrides() {
        // Esta configuração diz ao Quarkus: "Para o perfil de teste,
        // crie uma política de segurança chamada 'permit-all' que permite
        // o acesso a todos os caminhos ('/*') sem nenhuma verificação."
        return Map.of(
                "quarkus.http.auth.permission.default.paths", "/*",
                "quarkus.http.auth.permission.default.policy", "permit"
        );
    }
}