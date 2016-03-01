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

```
mvn compile exec:java -Pvat_details -Dexec.args="YOUR-USERNAME YOUR-SERVICE-PASSWORD YOUR-VAT REQUESTED-VAT"
```

If the requested VAT is 090165560, then the output should contain

```
A.F.M : 090165560   
Title : null
Onomasia : ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ ΓΕΝ Δ-ΝΣΗ Δ-ΚΗΣΥΠ-ΞΗΣ Δ ΟΙΚ
Registration date : 1993-02-08T00:00:00.000+02:00
Activate flag? : 1
Activate? : ΕΝΕΡΓΟΣ ΑΦΜ          
D.O.Y. : 1104
D.O.Y. Description : Δ΄ ΑΘΗΝΩΝ
Postal Address : Κ ΣΕΡΒΙΑΣ
```
## version.sh
Display the service's version.

This service can be used without a user name and a password. Example:
The code is written in Java using Maven and required Maven and Java installed.

Example:
```
mvn compile exec:java -Pvat_version
```

```
 The output should look somethings like (first time you might download a few more maven related jar dependencies)
 
 [INFO] Scanning for projects...
 [INFO]                                                                         
 [INFO] ------------------------------------------------------------------------
 [INFO] Building greek-vat-data 1.0-SNAPSHOT
 [INFO] ------------------------------------------------------------------------

Version: 3.1.0, 11/04/2014, Copyright Γ.Γ.Δ.Ε. / Γ.Γ.Π.Σ. 2014.Υπηρεσία "Βασικά στοιχεία μητρώου για νομικά πρόσωπα, νομικές οντότητες, και φυσικά πρόσωπα με εισόδημα από επιχειρηματική δραστηριότητα» με όριο κλήσεων και ταυτοποίηση χρήστη. 
```

