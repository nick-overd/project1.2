# project1.2
Inventory Management System
Created a Inventory Management System which is able to create, read, update and delete information which is inputed within the system. We created a MySQL database that synced with Java Eclipse which allowed the database to be retrieved from MySQL
Getting Started
Firstly create a sql instance on google cloud. .Then pull the code to your eclipse using gitbash. Change the ip addresses of the MySQL database within java to there own databases ip

Prerequisites
Eclipse: https://www3.ntu.edu.sg/home/ehchua/programming/howto/EclipseJava_HowTo.html
MySQL: https://dev.mysql.com/doc/mysql-installation-excerpt/8.0/en/windows-install-archive.html
Google Cloud Platform: https://cloud.google.com/sql/docs/mysql/quickstart
GitBash: https://git-scm.com/book/en/v2/Getting-Started-Installing-Git
Java: https://www3.ntu.edu.sg/home/ehchua/programming/howto/EclipseJava_HowTo.html
Maven: https://howtodoinjava.com/maven/how-to-install-maven-on-windows/


Installing
Set up a google cloud instance
Pull the repository from GitHub using the following commands using GitBash: git init git pull https://github.com/nick-overd/project1.2
Open repository into your IDE (Eclipse recommended)
Change all databases connections ip within the code to there own databases ip. This are located within there classes ims and all daoMysql
Run the application by pressing ctrl and f11 simultaneously. This will then prompt you to input your username and password to your own MySql database. The list of table names will then be presented and once a table is selected a series of commands will be displayed which allow for the table to be modified. The create function allows for a new item to be saved into the database. The read function shows all the items present in the database. For example read will pull all the information from the database table and input it into the console. The update function allows a item already in the database to be changed and the delete function removes a item from the database
Running the tests
Right click the test class in Java and run it in Junit. This will return wether the code works or not by showing pass or not pass
Unit Tests
Explain what these tests test, why and how to run them
Built With
Maven - Dependency Management
Versioning
We use SemVer for versioning.
Authors
Nick Overd  
License
This project is licensed under the MIT license - see the LICENSE.md file for details
Apache License, Version 2.0 (LICENSE-APACHE or http://www.apache.org/licenses/LICENSE-2.0)
MIT license (LICENSE-MIT or http://opensource.org/licenses/MIT)
Acknowledgments
Kobby mensah
Dan Parkes
