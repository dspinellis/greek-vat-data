# Get details for a Greek VAT code
Example php source which obtains VAT details from GSIS. This example
is run from the command-line. Compatible with php 5.3

Also includes a function which calls the VIES Soap VAT details services.


```
Example:
$ php greek-vat.php <username> <passsword> <callers vat> 090283815


Array
(
    [RgWsPublicBasicRt_out] => stdClass Object
        (
            [afm] => 090283815
            [stopDate] =>
            [postalAddressNo] => 20-2
            [doyDescr] => Δ΄ ΑΘΗΝΩΝ
            [doy] => 1104
            [onomasia] => ΥΠΟΥΡΓΕΙΟ ΠΟΛΙΤΙΣΜΟΥ
            [legalStatusDescr] => ΔΗΜΟΣΙΑ ΥΠΗΡΕΣΙΑ
            [registDate] => 1994-11-11T00:00:00.000+02:00
            [deactivationFlag] => 1
            [deactivationFlagDescr] => ΕΝΕΡΓΟΣ ΑΦΜ
            [postalAddress] => ΜΠΟΥΜΠΟΥΛΙΝΑΣ
            [firmFlagDescr] => ΕΠΙΤΗΔΕΥΜΑΤΙΑΣ
            [commerTitle] =>
            [postalAreaDescription] => ΑΘΗΝΑ
            [INiFlagDescr] => ΜΗ ΦΠ
            [postalZipCode] => 10682
        )

    [arrayOfRgWsPublicFirmActRt_out] => stdClass Object
        (
            [RgWsPublicFirmActRtUser] => stdClass Object
                (
                    [firmActDescr] => 75110000    ΓΕΝΙΚΕΣ ΔΡΑΣΤΗΡΙΟΤΗΤΕΣ ΔΗΜΟΣΙΩΝ ΥΠΗΡΕΣΙΩΝ
                    [firmActKind] => 1
                    [firmActKindDescr] => ΚΥΡΙΑ
                    [firmActCode] => 78593
                )

        )

    [pCallSeqId_out] => 558578788
    [pErrorRec_out] => stdClass Object
        (
            [errorDescr] =>
            [errorCode] =>
        )

)

VIES Results:
stdClass Object
(
    [countryCode] => EL
    [vatNumber] => 090283815
    [requestDate] => 2016-02-22+01:00
    [valid] => 1
    [name] => ΥΠΟΥΡΓΕΙΟ ΠΟΛΙΤΙΣΜΟΥ
    [address] => ΜΠΟΥΜΠΟΥΛΙΝΑΣ 20-2 10682 - ΑΘΗΝΑ
)
```

