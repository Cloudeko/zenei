package dev.cloudeko.zenei.domain.feature.impl;

import dev.cloudeko.zenei.domain.feature.SendMagicLinkVerifyEmail;
import dev.cloudeko.zenei.domain.model.email.EmailAddressInput;
import dev.cloudeko.zenei.domain.model.email.EmailAddressRepository;
import dev.cloudeko.zenei.domain.model.user.UserRepository;
import dev.cloudeko.zenei.domain.provider.MailTemplateProvider;
import dev.cloudeko.zenei.domain.provider.StringTokenProvider;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@ApplicationScoped
@AllArgsConstructor
public class SendMagicLinkVerifyEmailImpl implements SendMagicLinkVerifyEmail {

    private final Mailer mailer;
    private final StringTokenProvider stringTokenProvider;
    private final MailTemplateProvider mailTemplateProvider;

    private final UserRepository userRepository;
    private final EmailAddressRepository emailAddressRepository;

    @Override
    public void handle(EmailAddressInput input) {
        final var content = mailTemplateProvider.defaultCreateConfirmationMailTemplate(
                "http://localhost:8080/user/verify-email",
                input.getEmailAddress().getEmailVerificationToken());
        final var mail = Mail.withHtml(input.getEmailAddress().getEmail(), "Welcome to Zenei", content);

        mailer.send(mail);
    }
}
