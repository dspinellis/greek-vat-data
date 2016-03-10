// vatVersion.js

module.exports = function(){

    var data = '<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<env:Envelope\n  xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\"\n  xmlns:ns=\"http://gr/gsis/rgwspublic/RgWsPublic.wsdl\"\n  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n  xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n<env:Header/>\n<env:Body>\n<ns:rgWsPublicVersionInfo/>\n</env:Body>\n</env:Envelope>';

    return {
        postData: data,
        httpOptions: {
            host: 'www1.gsis.gr',
            port: '443',
            path: '/webtax2/wsgsis/RgWsPublic/RgWsPublicPort',
            method: 'POST',
            headers: {
            'Content-Type': 'application/soap+xml;charset=UTF-8',
                'Content-Length': data.length,
                'SOAPAction': 'http://gr/gsis/rgwspublic/RgWsPublic.wsdl/rgWsPublicVersionInfo'
            }
        }
    };
};
