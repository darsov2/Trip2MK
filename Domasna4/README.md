# Имплементација на шаблони за дизајн на софтвер во нашиот проект
Нашата апликација ја користи Spring рамката за развој за имплементација на backend делот. Иако поради природата на проблемот кој го решаваме и неговата едноставност, не користиме шаблон за дизајн на софтвер во самиот модел, нашиот код, со самата употреба на Spring и SOLID принципите на кои се темели, во целост е имплементиран врз база на неколку шаблони за дизајн на софтвер кои се среќаваат во повеќе компоненти. Еве некои од нив:
## **Шаблон Singleton**<br />
Секоја класа анотирана со @Component, @Service, @Controller, @Repository и слично е Bean и при секое инстацирање негово инстанцирање во нашата апликација, Spring Inversion Of Control контејнерот прави единствена инстанца од конкретниот Bean и ја вметнува секаде каде што е потребно.
## **Шаблон Factory**<br />
Како што споменавме претходно, класите во Spring имаат соодветни анотции коишто им даваат некакво значење и ги прават применливи во одреден контекст. За ова да функционира потребно е компонентите кои се зависни да се инјектираат и тоа е овозможено на неколку начини. Во секој случај при инјектирање на зависноста независно дали преку конструктор, set метода или автоматски со @Autowired анотацијата, всушност се прави инстанца од соодветниот Bean и ова практично претставува фабрика за Bean-ови која е контролирана од Spring Container-от. За ова попрактично да го демонстрираме, направивме наша фабирка за еден од сервисите во сервисниот слој - RestEmailServiceCommunication.<br /><br />
Фабриката е претставена преку следната класа<br />
```java
public class FactoryBean implements org.springframework.beans.factory.FactoryBean<RestEmailServiceCommunication> {
    @Override
    public RestEmailServiceCommunication getObject() throws Exception {
        return new RestEmailServiceCommunicationImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return RestEmailServiceCommunication.class;
    }
}
```

<br />Додека пак креирањето на инстанцата и нејзино инјектирање се случува преку стаичка метода која враќа нова инстанца од класата која го имплементира дадениот сервис <br /><br />

```java
public class RestEmailServiceFactory {
    public static RestEmailServiceCommunicationImpl createInstance()
    {
        return new RestEmailServiceCommunicationImpl();
    }
}
```

```java
    private final RestEmailServiceCommunication restEmailServiceCommunication;

    public RegistrationEmailListener(KorisniciService korisniciService, Environment environment) {
        this.korisniciService = korisniciService;
        this.environment = environment;
        this.restEmailServiceCommunication = RestEmailServiceFactory.createInstance();
    }
```
## **Шаблон Observer**<br />
Spring претставува event-driven архитектура, односно им овозможува на компононетите да комуницираат преку пропагација на настани во улога на publisher и subscriber. Овој механизам е типичен пример за примена на шаблонот Observer. И покарј тоа што голем дел од предефинираните компоненти во Spring комуницираат на овој начин, направивме custom имплементација на овој шаблон за едно сценарио. <br />
```java
public class OnRegistrationSuccessEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String appUrl;
    private Korisnici user;

    //getter, setters, constructors
}
```
Имено, при регистрација на нов корисник од страна на контролерот се исплаува настан кој го пречекува новодефнираниот listener и соодветно се извршува логиката за испраќање на порака за потврда на регистрацијата преку новоимплемнтираниот mailing микросервис.
```java
    @Autowired
    private final ApplicationEventPublisher eventPublisher;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest,
                               WebRequest request) {

        //userName duplication checks

        Korisnici user = userService.saveUser(signUpRequest);
        eventPublisher.publishEvent(new OnRegistrationSuccessEvent(user, request.getContextPath()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
```

```java
@Component
public class RegistrationEmailListener implements ApplicationListener<OnRegistrationSuccessEvent> {
    //dependencies injections
    //getters, setters, constructors

    @Override
    public void onApplicationEvent(OnRegistrationSuccessEvent event) {
        //logic when event is listened to
        Korisnici u = event.getUser();
        String url = environment.getProperty("email-service.url");
        String to = u.getEmail();
        String link = event.getAppUrl() + "/auth/confirm?token=" + u.getToken();
        String subject = "Trip2MK - Registration Confirmation";
        String message = "Dear,\n\nWe are happy to have you here. In order to enable your account, you have to confirm your registration on the following link \n\n" + link;
        restEmailServiceCommunication.GetEmailSend(url + "/api/email/send", to, subject, message);
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
```

## **Шаблон Template**
Концептот на Interface Segregation од SOLID принципите е точно она коешто го овозможува шаблонот Template, па така повторно можеме да кажеме дека нашиот код „несвесно“ го имплементира и него. Истиот овозможува при наследување од класа или проширување на некој интерфејс корисникот да одлучи дали и кои апстрактни функции ќе ги препокрие.
