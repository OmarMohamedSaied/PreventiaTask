# PREVENTIA TASK

Chosen testing tool : Selenium with TestNG

Design pattern applied : POM

To run tests locally all you have to do is to open '**testng.xml**' file and click run tests

Selected Scenarios WEB : Login with Valid Credentials , Login with invalid Credentials , Add Items successfully to cart

Selected Scenarios APIs : Create new user , get user and delete user

Reason for selection of these scenarios(Web) : It is important to be able to login successfully in order to proceed with other features in application ,
also we have to make sure that any wrong credentials won't proceed user to products listing ,
and then the last scenario was that to make sure that if user added any product to cart he must find it successfully added to cart since main scope of this app is to purchase items.

Reason for selection of these scenarios(APIs) : It is important to be able to create user as without users on system , system won't have much value.
also it is important to be able to get users created in order to be able to get data of users created
and also we have chosen to test delete user since any redundant data in DB would make DB full of unwanted data which will affect performance of BE and will be cost more money to increase
DB capacity while no need of this , so it is important in any scenario if there is add feature then there must be delete feature.




Next steps in this automation script :

1- Do more TCs to cover more features

2- Integrate with Jenkins

3- Modify code to run on more than platform
