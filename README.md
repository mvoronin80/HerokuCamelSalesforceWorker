Demonstration project for DreamForce'17. Apache Camel based Salesforce integration on Heroku platform.
This project is worker part (catching messaging from Telegram contact weather info and create case in Salesforce).
Installation steps:
0. Create connected app in Salesforce: full access, Relax IP restrictions, all users may self authorize
1. Install unmanaged package with Apex Class and custom fields (https://login.salesforce.com/packaging/installPackage.apexp?p0=04t1I000002Ry78&isdtp=p1)
2. Create new Process using Process Builder
	2.1. Object is Case, start process any time object created or changed.
	2.2. Conditions: (Case.Status is changed) AND (Case.Telegram Chat Id NOT NULL)
	2.3. Condition met: immediate action = Apex Class "Notify Camel on Case Status change"
	2.4. Action parameters: "cases" is Field Reference to [Case]
	2.5. Save and activate process
3. Create a Contact in Salesforce with your First Name = John LastName = Smith, Mailing City = Phoenix, Mailing State = AZ
4. Create account in Telegram (https://telegram.org/apps)
5. Rename yourself in Telegram to John Smith (contact first name and last name in Telegram should match contact's in Salesforce)
6. Create your bot in Telegram (this is a API controlled account). https://core.telegram.org/bots After you bot is done you'll have a bot's token. That is a token for API ot access bot
7. Create account on http://openweathermap.org. After account is create obtain API key for openweathermap here https://home.openweathermap.org/api_keys
8. In source code replace:
	8.1. Salesforce ClientId, ClientSecret (from Connected App step 0), Username, Password
	8.2. Telegram token from("telegram:bots/{here is you token}").
	8.3. Weather API key .toD("weather:get?location=${body.records[0].getMailingCity}&appid={you key is here}")
9. Create heroku app "heroku apps:create example"
10. Save changes to local git repo
11. Push git changes to heroku
12. Scale heroku app "heroku ps:scale worker=0"

