package utils;

import org.jetbrains.annotations.NotNull;

/**
 * Нужно добавить переменные окружения. Пример:
 * <p>
 * ok.login=78005553535;ok.password=12345678QWERTY
 * <p>
 * в IDEA: Edit configurations... > Run > Environment variables
 */
public record User(@NotNull String login, @NotNull String password) {
    public static User fromProperties() {
        return new User(
                System.getenv("ok.login"),
                System.getenv("ok.password"));
    }
}
