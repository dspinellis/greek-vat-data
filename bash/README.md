# Get details for a Greek VAT code
Here are Unix shell scripts that obtain the details associated with
a Greek VAT number, by calling the web service provided by the Greek
Public Revenue Authority and the General Secretariat of Information
Systems at the Greek Ministry of Finance.

Details about the provided files appear below.

## vat-details.sh
Obtain the details for a given VAT.
To run this script you need to register and
obtain a user name and a password for
using this service from the
[GSIS site](https://www1.gsis.gr/webtax/wspublicreg).
The script is written in Bash and requires the
[cURL](https://en.wikipedia.org/wiki/CURL) tool to run.
Example:
```
./vat-details.sh YOUR-USERNAME YOUR-SERVICE-PASSWORD YOUR-VAT 090165560 |
xml fo -e utf-8 -
<?xml version="1.0" encoding="utf-8"?>
<env:Envelope xmlns:env="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <env:Header/>
  <env:Body>
    <m:rgWsPublicAfmMethodResponse xmlns:m="http://gr/gsis/rgwspublic/RgWsPublic.wsdl">
      <RgWsPublicBasicRt_out>
        <m:afm>090165560   </m:afm>
        <m:stopDate xsi:nil="true"/>
        <m:postalAddressNo>10       </m:postalAddressNo>
        <m:doyDescr>Δ΄ ΑΘΗΝΩΝ</m:doyDescr>
        <m:doy>1104</m:doy>
        <m:onomasia>ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ ΓΕΝ Δ-ΝΣΗ Δ-ΚΗΣΥΠ-ΞΗΣ Δ ΟΙΚ</m:onomasia>
        <m:legalStatusDescr>ΔΗΜΟΣΙΑ ΥΠΗΡΕΣΙΑ</m:legalStatusDescr>
        <m:registDate>1993-02-08T00:00:00.000+02:00</m:registDate>
        <m:deactivationFlag>1</m:deactivationFlag>
        <m:deactivationFlagDescr>ΕΝΕΡΓΟΣ ΑΦΜ          </m:deactivationFlagDescr>
        <m:postalAddress>Κ ΣΕΡΒΙΑΣ</m:postalAddress>
        <m:firmFlagDescr>ΕΠΙΤΗΔΕΥΜΑΤΙΑΣ      </m:firmFlagDescr>
        <m:commerTitle xsi:nil="true"/>
        <m:postalAreaDescription>ΑΘΗΝΑ</m:postalAreaDescription>
        <m:INiFlagDescr>ΜΗ ΦΠ</m:INiFlagDescr>
        <m:postalZipCode>10110</m:postalZipCode>
      </RgWsPublicBasicRt_out>
      <arrayOfRgWsPublicFirmActRt_out>
        <m:RgWsPublicFirmActRtUser>
          <m:firmActDescr>ΓΕΝΙΚΕΣ ΔΗΜΟΣΙΕΣ ΥΠΗΡΕΣΙΕΣ</m:firmActDescr>
          <m:firmActKind>1</m:firmActKind>
          <m:firmActKindDescr>ΚΥΡΙΑ</m:firmActKindDescr>
          <m:firmActCode>84111000</m:firmActCode>
        </m:RgWsPublicFirmActRtUser>
      </arrayOfRgWsPublicFirmActRt_out>
      <pCallSeqId_out>558277564</pCallSeqId_out>
      <pErrorRec_out>
        <m:errorDescr xsi:nil="true"/>
        <m:errorCode xsi:nil="true"/>
      </pErrorRec_out>
    </m:rgWsPublicAfmMethodResponse>
  </env:Body>
</env:Envelope>
```

## version.sh
Display the service's version.
This can be used without a user name and a password.  Example:
The script is written in Bash and requires the
[cURL](https://en.wikipedia.org/wiki/CURL) tool to run.
```
./version.sh | xml fo -e utf-8 -
<?xml version="1.0" encoding="utf-8"?>
<env:Envelope xmlns:env="http://schemas.xmlsoap.org/soap/envelope/">
  <env:Header/>
  <env:Body>
    <m:rgWsPublicVersionInfoResponse xmlns:m="http://gr/gsis/rgwspublic/RgWsPublic.wsdl">
      <result>Version: 3.1.0, 11/04/2014, Copyright Γ.Γ.Δ.Ε. / Γ.Γ.Π.Σ. 2014.Υπηρεσία "Βασικά στοιχεία μητρώου για νομικά πρόσωπα, νομικές οντότητες, και φυσικά πρόσωπα με εισόδημα από επιχειρηματική δραστηριότητα» με όριο κλήσεων και ταυτοποίηση χρήστη.</result>
    </m:rgWsPublicVersionInfoResponse>
  </env:Body>
</env:Envelope>
```

## tab-separated.xslt
Convert the service's XML data into a tab-separated line, which you
can then paste into Excel.
This has been tested with [XMLStarlet](http://xmlstar.sourceforge.net/).
Example:
```
./vat-details.sh YOUR-USERNAME YOUR-SERVICE-PASSWORD YOUR-VAT 090165560 |
xml tr tab-separated.xslt
ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ ΓΕΝ Δ-ΝΣΗ Δ-ΚΗΣΥΠ-ΞΗΣ Δ ΟΙΚ	ΓΕΝΙΚΕΣ ΔΗΜΟΣΙΕΣ ΥΠΗΡΕΣΙΕΣ		090165560   	Δ΄ ΑΘΗΝΩΝ	Κ ΣΕΡΒΙΑΣ 10       		10110 ΑΘΗΝΑ
```
