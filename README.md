# BE-DAVID-MWANGI-0729003109
Cellulant Interview
============
How to run the application
--------
*1 Create a mysql database with the name cellulant.
*2.Create a user root with password root to the database cellulant.
  This can also be configured under /main/resources/application.properties when running from an IDE

*To run the application from an IDE
import the project and build with dependencies
Locate 
1) company.wsdl.FetchDepartments; and add @XmlRootElement(name = "fetchDepartments")
2) company.wsdl.FetchStaff and add @XmlRootElement(name = "fetchStaff")

Then run the application

To run from a jar file
use java -jar interview-v1.0.2.jar

