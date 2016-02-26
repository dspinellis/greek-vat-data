# Get details for a Greek VAT code

Here are examples that obtain the details associated with
a Greek VAT number, by calling the web service provided by the Greek
Public Revenue Authority and the General Secretariat of Information
Systems at the Greek Ministry of Finance.

Details about the provided files appear below.

## vat-details.sh
Obtain the details for a given VAT.
To run the code you need to register and
obtain a user name and a password for
using this service from the
[GSIS site](https://www1.gsis.gr/webtax/wspublicreg).
The script is written in Java using [Maven]. You need to install Java and maven to run these examples.

TODO: To be implemented.

## version.sh
Display the service's version.

This service can be used without a user name and a password. Example:
The code is written in Java using Maven and required Maven and Java installed.

```

```

## tab-separated.xslt
Convert the service's XML data into a tab-separated line, which you
can then paste into Excel.

Example:
```
 mvn compile exec:java -Pvat_version
 ```
 
 The output should look somethings like (first time you might download a few more maven related jar dependencies)
 
 [INFO] Scanning for projects...
 [INFO]                                                                         
 [INFO] ------------------------------------------------------------------------
 [INFO] Building greek-vat-data 1.0-SNAPSHOT
 [INFO] ------------------------------------------------------------------------

Version: 3.1.0, 11/04/2014, Copyright Γ.Γ.Δ.Ε. / Γ.Γ.Π.Σ. 2014.Υπηρεσία "Βασικά στοιχεία μητρώου για νομικά πρόσωπα, νομικές οντότητες, και φυσικά πρόσωπα με εισόδημα από επιχειρηματική δραστηριότητα» με όριο κλήσεων και ταυτοποίηση χρήστη. 
```

