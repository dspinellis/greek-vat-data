// vatVersion.js

module.exports = function(userName, password, vatBy, vatFor) {

    var moduleExports = {};

    /**
     * Construct SOAP request XML
     *
     * @param userName GSIS username
     * @param password GSIS password
     * @param vatBy Greek VAT of requester (above username/password issued with this VAT)
     * @param vatFor Greek VAT to request information
     * @returns {string} Request SOAP XML
     */
    var data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<env:Envelope\n  xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\"\n  xmlns:ns=\"http://gr/gsis/rgwspublic/RgWsPublic.wsdl\"\n  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n  xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n  xmlns:ns1=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n  <env:Header>\n    <ns1:Security>\n      <ns1:UsernameToken>\n\t<ns1:Username>" + userName + "</ns1:Username>\n\t<ns1:Password>" + password + "</ns1:Password>\n      </ns1:UsernameToken>\n    </ns1:Security>\n  </env:Header>\n  <env:Body>\n    <ns:rgWsPublicAfmMethod>\n      <RgWsPublicInputRt_in xsi:type=\"ns:RgWsPublicInputRtUser\">\n\t<ns:afmCalledBy>" + vatBy + "</ns:afmCalledBy>\n\t<ns:afmCalledFor> " + vatFor + "</ns:afmCalledFor>\n      </RgWsPublicInputRt_in>\n      <RgWsPublicBasicRt_out xsi:type=\"ns:RgWsPublicBasicRtUser\">\n\t<ns:afm xsi:nil=\"true\"/>\n\t<ns:stopDate xsi:nil=\"true\"/>\n\t<ns:postalAddressNo xsi:nil=\"true\"/>\n\t<ns:doyDescr xsi:nil=\"true\"/>\n\t<ns:doy xsi:nil=\"true\"/>\n\t<ns:onomasia xsi:nil=\"true\"/>\n\t<ns:legalStatusDescr xsi:nil=\"true\"/>\n\t<ns:registDate xsi:nil=\"true\"/>\n\t<ns:deactivationFlag xsi:nil=\"true\"/>\n\t<ns:deactivationFlagDescr xsi:nil=\"true\"/>\n\t<ns:postalAddress xsi:nil=\"true\"/>\n\t<ns:firmFlagDescr xsi:nil=\"true\"/>\n\t<ns:commerTitle xsi:nil=\"true\"/>\n\t<ns:postalAreaDescription xsi:nil=\"true\"/>\n\t<ns:INiFlagDescr xsi:nil=\"true\"/>\n\t<ns:postalZipCode xsi:nil=\"true\"/>\n      </RgWsPublicBasicRt_out>\n      <arrayOfRgWsPublicFirmActRt_out xsi:type=\"ns:RgWsPublicFirmActRtUserArray\"/>\n      <pCallSeqId_out xsi:type=\"xsd:decimal\">0</pCallSeqId_out>\n      <pErrorRec_out xsi:type=\"ns:GenWsErrorRtUser\">\n\t<ns:errorDescr xsi:nil=\"true\"/>\n\t<ns:errorCode xsi:nil=\"true\"/>\n      </pErrorRec_out>\n    </ns:rgWsPublicAfmMethod>\n  </env:Body>\n</env:Envelope>";

    moduleExports.httpOptions = {
        host: 'www1.gsis.gr',
        port: '443',
        path: '/webtax2/wsgsis/RgWsPublic/RgWsPublicPort',
        method: 'POST',
        headers: {
            'Content-Type': 'application/soap+xml;charset=UTF-8',
            'Content-Length': data.length,
            'SOAPAction': 'http://gr/gsis/rgwspublic/RgWsPublic.wsdl/rgWsPublicAfmMethod'
        }
    };

    moduleExports.postQueryData = data;

    return moduleExports;
};

