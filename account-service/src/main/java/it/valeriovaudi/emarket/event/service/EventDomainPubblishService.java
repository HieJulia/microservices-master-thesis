package it.valeriovaudi.emarket.event.service;

import it.valeriovaudi.emarket.event.factory.DomainEventFactory;
import it.valeriovaudi.emarket.event.model.*;
import it.valeriovaudi.emarket.event.repository.*;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * Created by mrflick72 on 04/05/17.
 */

@Service
public class EventDomainPubblishService {

    private final  DomainEventFactory domainEventFactory;

    private final AccountCreationEventRepository accountCreationEventRepository;
    private final AccountNotFoundEventRepository accountNotFoundEventRepository;
    private final AccountValidationErrorEventRepository accountValidationErrorEventRepository;
    private final ChangeAccountPasswordEventRepository changeAccountPasswordEventRepository;
    private final IdentityValidationErrorEventRepository identityValidationErrorEventRepository;
    private final RemoveAccountErrorEventRepository removeAccountErrorEventRepository;
    private final RemoveAccountEventRepository removeAccountEventRepository;
    private final SaveAccountErrorEventRepository saveAccountErrorEventRepository;

    private final PublishSubscribeChannel accountEventOutboundChannel;

    public EventDomainPubblishService(DomainEventFactory domainEventFactory,
                                      AccountCreationEventRepository accountCreationEventRepository,
                                      AccountNotFoundEventRepository accountNotFoundEventRepository,
                                      AccountValidationErrorEventRepository accountValidationErrorEventRepository,
                                      ChangeAccountPasswordEventRepository changeAccountPasswordEventRepository,
                                      IdentityValidationErrorEventRepository identityValidationErrorEventRepository,
                                      RemoveAccountErrorEventRepository removeAccountErrorEventRepository,
                                      RemoveAccountEventRepository removeAccountEventRepository,
                                      SaveAccountErrorEventRepository saveAccountErrorEventRepository,
                                      PublishSubscribeChannel accountEventOutboundChannel) {
        this.domainEventFactory = domainEventFactory;
        this.accountCreationEventRepository = accountCreationEventRepository;
        this.accountNotFoundEventRepository = accountNotFoundEventRepository;
        this.accountValidationErrorEventRepository = accountValidationErrorEventRepository;
        this.changeAccountPasswordEventRepository = changeAccountPasswordEventRepository;
        this.identityValidationErrorEventRepository = identityValidationErrorEventRepository;
        this.removeAccountErrorEventRepository = removeAccountErrorEventRepository;
        this.removeAccountEventRepository = removeAccountEventRepository;
        this.saveAccountErrorEventRepository = saveAccountErrorEventRepository;
        this.accountEventOutboundChannel = accountEventOutboundChannel;
    }

    public void publishAccountCreationEvent(String correlationId, String userName){
        AccountCreationEvent event = domainEventFactory.newAccountCreationEvent(correlationId, userName);
        accountCreationEventRepository.save(event);
        accountEventOutboundChannel.send(MessageBuilder.withPayload(event).build());
    }

    public void publishAccountNotFoundEvent(String correlationId, String userName){
        AccountNotFoundEvent event = domainEventFactory.newAccountNotFoundEvent(correlationId, userName);
        accountNotFoundEventRepository.save(event);
        accountEventOutboundChannel.send(MessageBuilder.withPayload(event).build());
    }

    public void publishAccountValidationErrorEvent(String correlationId, Map<String,String> errors){
        AccountValidationErrorEvent event = domainEventFactory.newAccountValidationErrorEvent(correlationId, errors);
        accountValidationErrorEventRepository.save(event);
        accountEventOutboundChannel.send(MessageBuilder.withPayload(event).build());
    }

    public void publishChangeAccountPasswordEvent(String correlationId, String userName){
        ChangeAccountPasswordEvent event = domainEventFactory.newChangeAccountPasswordEvent(correlationId, userName);
        changeAccountPasswordEventRepository.save(event);
        accountEventOutboundChannel.send(MessageBuilder.withPayload(event).build());
    }

    public void publishIdentityValidationErrorEvent(String correlationId, String userName, String message){
        IdentityValidationErrorEvent event = domainEventFactory.newIdentityValidationErrorEvent(correlationId, userName, message);
        identityValidationErrorEventRepository.save(event);
        accountEventOutboundChannel.send(MessageBuilder.withPayload(event).build());
    }

    public void publishRemoveAccountErrorEvent(String correlationId, String userName, Exception exception){
        RemoveAccountErrorEvent event = domainEventFactory.newRemoveAccountErrorEvent(correlationId, userName, exception);
        removeAccountErrorEventRepository.save(event);
        accountEventOutboundChannel.send(MessageBuilder.withPayload(event).build());
    }

    public void publishRemoveAccountEvent(String correlationId, String userName){
        RemoveAccountEvent event = domainEventFactory.newRemoveAccountEvent(correlationId, userName);
        removeAccountEventRepository.save(event);
        accountEventOutboundChannel.send(MessageBuilder.withPayload(event).build());
    }

    public void publishSaveAccountErrorEvent(String correlationId,String userName, Exception exception){
        SaveAccountErrorEvent event = domainEventFactory.newSaveAccountErrorEvent(correlationId, userName, exception);
        saveAccountErrorEventRepository.save(event);
        accountEventOutboundChannel.send(MessageBuilder.withPayload(event).build());
    }
}