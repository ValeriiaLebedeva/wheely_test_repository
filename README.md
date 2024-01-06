# UI WEB tests

### https://wheely.com/en

# Test-cases
1. The navigation bar menu shows expected buttons for the selected locale.
2. The chauffeur page. The callout form shows expected selected city corresponds to selected locale.
3. The 'Cities & Classes' page has the expected list of cities for the EN locale.
4. The Cities & Classes page has the expected lead text - EN locale.
5. The Cities & Classes page has the expected title text - EN locale.


# Used technologies

<p  align="center">

<img width="5%" title="IntelliJ IDEA" src="media/icons/Idea.svg">
<img width="5%" title="Java" src="media/icons/Java.svg">
<img width="5%" title="Selenoid" src="media/icons/Selenoid.svg">
<img width="5%" title="Selenide" src="media/icons/Selenide.svg">
<img width="5%" title="Gradle" src="media/icons/Gradle.svg">
<img width="5%" title="Junit5" src="media/icons/Junit5.svg">
<img width="5%" title="GitHub" src="media/icons/GitHub.svg">
<img width="5%" title="Allure Report" src="media/icons/Allure.svg">
<img width="5%" title="Allure TestOps" src="media/icons/Allure_TO.svg">
<img width="5%" title="Jenkins" src="media/icons/Jenkins.svg">
<img width="5%" title="Jira" src="media/icons/Jira.svg">
<img width="5%" title="Telegram" src="media/icons/Telegram.svg">
</p>

# USAGE examples
## Run tests from terminal
### Run tests with filled remote properties:

```bash
gradle clean test
```

### Run tests with not filled remote properties:

```bash
gradle clean test -DbrowserVersion=${BROWSERVERSION} -DbrowserSize=${BROWSERSIZE}
```

### Running parameters

<code>BROWSERVERSION</code> – browser version (_default - <code>100</code>_).

<code>BROWSERSIZE</code> – browser window size (_default - <code>1920x1080</code>_).

### Serve report:

```bash
allure serve build/allure-results
```


# Jenkins job
### https://jenkins.autotests.cloud/job/ValeriyaLebedeva_wheely_autotests/

How to build project:
1. Click on the 'Build with parameters'
2. Click on the 'Build' button

<p align="center">
  <img src="media/jenkins1.png">
</p>


# Allure report examples

The results of the build can be viewed in the Allure report by clicking on the icon <code><strong>*Allure Report*</strong></code>.

<p align="center">
  <img src="media/jenkinsreport1.png">
</p>

Overwiew

<p align="center">
  <img src="media/allurereport1.png">
</p>

Each test has steps described:
<p align="center">
  <img src="media/allurereport2.png">
</p>

Each test has last screenshot attached:
<p align="center">
  <img src="media/allurereport3.png">
</p>

Another attachments you may find here:
https://jenkins.autotests.cloud/job/ValeriyaLebedeva_wheely_autotests/35/allure/

(select suits item -> select test -> enjoy :innocent:)

# Allure TestOps integration

<p align="center">
  <img src="media/alluretestops1.png">
</p>

<p align="center">
  <img src="media/alluretestops2.png">
</p>

# Jira integration
<p align="center">
  <img src="media/jiraintegration.png">
</p>


# Telegram notifications
The project is configured to send launch results notifications to Telegram channel:

<p align="center">
  <img src="media/telegram.png">
</p>



