#!/bin/bash
#
# Request details for a VAT from the GSIS SOAP web service
#
# Copyright 2016 Diomidis Spinellis
#
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.

USERNAME="$1"
PASSWORD="$2"
VATBY="$3"
VATFOR="$4"

ACTION=http://gr/gsis/rgwspublic/RgWsPublic.wsdl/rgWsPublicAfmMethod
ENDPOINT=https://www1.gsis.gr:443/webtax2/wsgsis/RgWsPublic/RgWsPublicPort

if ! [ "$VATFOR" ] ; then
  echo "Usage: $0 username password requester-VAT query-VAT" 1>&2
  exit 1
fi

curl --silent \
  --header 'Content-Type: application/soap+xml;charset=UTF-8' \
  -X POST \
  --header "SOAPAction: $ACTION" \
  -d @<(cat <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<env:Envelope
  xmlns:env="http://schemas.xmlsoap.org/soap/envelope/"
  xmlns:ns="http://gr/gsis/rgwspublic/RgWsPublic.wsdl"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns:xsd="http://www.w3.org/2001/XMLSchema"
  xmlns:ns1="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd">
  <env:Header>
    <ns1:Security>
      <ns1:UsernameToken>
	<ns1:Username>$USERNAME</ns1:Username>
	<ns1:Password>$PASSWORD</ns1:Password>
      </ns1:UsernameToken>
    </ns1:Security>
  </env:Header>
  <env:Body>
    <ns:rgWsPublicAfmMethod>
      <RgWsPublicInputRt_in xsi:type="ns:RgWsPublicInputRtUser">
	<ns:afmCalledBy>$VATBY</ns:afmCalledBy>
	<ns:afmCalledFor>$VATFOR</ns:afmCalledFor>
      </RgWsPublicInputRt_in>
      <RgWsPublicBasicRt_out xsi:type="ns:RgWsPublicBasicRtUser">
	<ns:afm xsi:nil="true"/>
	<ns:stopDate xsi:nil="true"/>
	<ns:postalAddressNo xsi:nil="true"/>
	<ns:doyDescr xsi:nil="true"/>
	<ns:doy xsi:nil="true"/>
	<ns:onomasia xsi:nil="true"/>
	<ns:legalStatusDescr xsi:nil="true"/>
	<ns:registDate xsi:nil="true"/>
	<ns:deactivationFlag xsi:nil="true"/>
	<ns:deactivationFlagDescr xsi:nil="true"/>
	<ns:postalAddress xsi:nil="true"/>
	<ns:firmFlagDescr xsi:nil="true"/>
	<ns:commerTitle xsi:nil="true"/>
	<ns:postalAreaDescription xsi:nil="true"/>
	<ns:INiFlagDescr xsi:nil="true"/>
	<ns:postalZipCode xsi:nil="true"/>
      </RgWsPublicBasicRt_out>
      <arrayOfRgWsPublicFirmActRt_out xsi:type="ns:RgWsPublicFirmActRtUserArray"/>
      <pCallSeqId_out xsi:type="xsd:decimal">0</pCallSeqId_out>
      <pErrorRec_out xsi:type="ns:GenWsErrorRtUser">
	<ns:errorDescr xsi:nil="true"/>
	<ns:errorCode xsi:nil="true"/>
      </pErrorRec_out>
    </ns:rgWsPublicAfmMethod>
  </env:Body>
</env:Envelope>
EOF
) $ENDPOINT
