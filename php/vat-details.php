<?php
/*
#
# Request details for a VAT from the GSIS SOAP web service
#
# Copyright 2016 Spiros Ioannou
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
#  
*/

/* This is an example on how to build the PHP Soap call */

if ($argc != 5) {
	echo "Usage: php greek-vat.php <username> <password> requester-VAT query-VAT";
	exit;
}


$username=$argv[1];
$password=$argv[2];
$myafm=$argv[3];
$afm=$argv[4];

//Make call
$result = checkVATGR($username,$password,$myafm,$afm);

//print results
print_r($result);


echo "\nVIES Results:\n";
//Make call to VIES
$result_eu=checkVATEU($afm);
//print results
print_r($result_eu);



/* 
 * $username:  username & password από εδώ: http://gsis.gr/gsis/info/gsis_site/PublicIssue/wnsp/wnsp_pages/wnsp.html
 * $password: 
 * $AFMCalledby: ΑΦΜ εξουσιοδοτούντος ή κενό (οπότε εννοείται το ΑΦΜ του username)
 * $AFMCalledfor: Το ΑΦΜ που αναζητούμε
 */

function checkVATGR($username,$password,$AFMcalledby="",$AFMcalledfor)
{
    $client = new SoapClient( "https://www1.gsis.gr/webtax2/wsgsis/RgWsPublic/RgWsPublicPort?WSDL",array('trace' => true) );

	//$version = $client->rgWsPublicVersionInfo();

	$authHeader = new stdClass();
	$authHeader->UsernameToken->Username = "$username";
	$authHeader->UsernameToken->Password = "$password";
	$Headers[] = new SoapHeader('http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd', 'Security', $authHeader,TRUE);
	$client->__setSoapHeaders($Headers);

    $result = $client->rgWsPublicAfmMethod(
		array(
			'afmCalledBy'=>"$AFMcalledby",
			'afmCalledFor'=>"$AFMcalledfor",
			)
		);

	return $result;
}	


function checkVATEU($vatNo)
{
    //$client = new SoapClient( "http://ec.europa.eu/taxation_customs/vies/checkVatService.wsdl");
    $client = new SoapClient( "checkVatService.wsdl");
    $result = $client->checkVat(array('countryCode'=>'EL','vatNumber'=>$vatNo));

	return $result;
}	


?>
