#!/bin/bash
ACTION=http://gr/gsis/rgwspublic/RgWsPublic.wsdl/rgWsPublicVersionInfo
ENDPOINT=https://www1.gsis.gr:443/webtax2/wsgsis/RgWsPublic/RgWsPublicPort

curl -s -H "Content-Type: text/xml; charset=utf-8" \
  -X POST \
  -H "SOAPAction: $ACTION" \
  -d @<(cat <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<env:Envelope
  xmlns:env="http://schemas.xmlsoap.org/soap/envelope/"
  xmlns:ns="http://gr/gsis/rgwspublic/RgWsPublic.wsdl"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns:xsd="http://www.w3.org/2001/XMLSchema">
<env:Header/>
<env:Body>
<ns:rgWsPublicVersionInfo/>
</env:Body>
</env:Envelope>
EOF
) $ENDPOINT
