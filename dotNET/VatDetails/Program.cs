/*
#
# Request details for a VAT from the GSIS SOAP web service
#
# Copyright 2016 Dimitris - Ilias Gkanatsios www.dgkanatsios.com
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

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;

namespace VatDetails
{
    class Program
    {
        /// <summary>
        /// Executes a call to GSIS web service
        /// </summary>
        /// <param name="username">Username issued</param>
        /// <param name="password">Password</param>
        /// <param name="afmCalledBy">VAT number of the caller</param>
        /// <param name="afmCalledFor">VAT number to check</param>
        /// <returns>Displays SOAP message on console and returns a VATResult object containing all the information</returns>
        public static VATResult Execute(string username, string password, string afmCalledBy, string afmCalledFor)
        {
            HttpWebRequest request = CreateWebRequest();
            XmlDocument soapEnvelopeXml = new XmlDocument();
            string xml = @"<?xml version=""1.0"" encoding=""UTF-8""?>
                <env:Envelope
                xmlns:env=""http://schemas.xmlsoap.org/soap/envelope/""
                xmlns:ns=""http://gr/gsis/rgwspublic/RgWsPublic.wsdl""
                xmlns:xsi=""http://www.w3.org/2001/XMLSchema-instance""
                xmlns:xsd=""http://www.w3.org/2001/XMLSchema""
                xmlns:ns1=""http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-
                1.0.xsd"">
                <env:Header>
                <ns1:Security>
                <ns1:UsernameToken>
                <ns1:Username>$username$</ns1:Username>
                <ns1:Password>$password$</ns1:Password>
                </ns1:UsernameToken>
                </ns1:Security>
                </env:Header>
                <env:Body>
                <ns:rgWsPublicAfmMethod>
                <RgWsPublicInputRt_in xsi:type=""ns:RgWsPublicInputRtUser"">
                <ns:afmCalledBy>$afmCalledBy$</ns:afmCalledBy>
                <ns:afmCalledFor>$afmCalledFor$</ns:afmCalledFor>
                </RgWsPublicInputRt_in>
                <RgWsPublicBasicRt_out xsi:type=""ns:RgWsPublicBasicRtUser"">
                <ns:afm xsi:nil=""true""/>
                <ns:stopDate xsi:nil=""true""/>
                <ns:postalAddressNo xsi:nil=""true""/>
                <ns:doyDescr xsi:nil=""true""/>
                <ns:doy xsi:nil=""true""/>
                <ns:onomasia xsi:nil=""true""/>
                <ns:legalStatusDescr xsi:nil=""true""/>
                <ns:registDate xsi:nil=""true""/>
                <ns:deactivationFlag xsi:nil=""true""/>
                <ns:deactivationFlagDescr xsi:nil=""true""/>
                <ns:postalAddress xsi:nil=""true""/>
                <ns:firmFlagDescr xsi:nil=""true""/>
                <ns:commerTitle xsi:nil=""true""/>
                <ns:postalAreaDescription xsi:nil=""true""/>
                <ns:INiFlagDescr xsi:nil=""true""/>
                <ns:postalZipCode xsi:nil=""true""/>
                </RgWsPublicBasicRt_out>
                <arrayOfRgWsPublicFirmActRt_out xsi:type=""ns:RgWsPublicFirmActRtUserArray""/>
                <pCallSeqId_out xsi:type=""xsd:decimal"">0</pCallSeqId_out>
                <pErrorRec_out xsi:type=""ns:GenWsErrorRtUser"">
                <ns:errorDescr xsi:nil=""true""/>
                <ns:errorCode xsi:nil=""true""/>
                </pErrorRec_out>
                </ns:rgWsPublicAfmMethod>
                </env:Body>
                </env:Envelope>";

            xml = xml.Replace("$username$", username).Replace("$password$", password)
                .Replace("$afmCalledBy$", afmCalledBy).Replace("$afmCalledFor$", afmCalledFor);

            soapEnvelopeXml.LoadXml(xml);

            using (Stream stream = request.GetRequestStream())
            {
                soapEnvelopeXml.Save(stream);
            }

            using (WebResponse response = request.GetResponse())
            {
                using (StreamReader rd = new StreamReader(response.GetResponseStream()))
                {
                    string soapResult = rd.ReadToEnd();
                    Console.WriteLine(soapResult);
                    return VATResult.FromXMLString(soapResult);
                }
            }
        }
        /// <summary>
        /// Create a soap webrequest to GSIS Web Service URL
        /// </summary>
        /// <returns>The webRequest object</returns>
        public static HttpWebRequest CreateWebRequest()
        {
            HttpWebRequest webRequest = (HttpWebRequest)WebRequest.Create(@"https://www1.gsis.gr/webtax2/wsgsis/RgWsPublic/RgWsPublicPort");
            webRequest.Headers.Add(@"SOAP:Action");
            webRequest.ContentType = "text/xml;charset=\"utf-8\"";
            webRequest.Accept = "text/xml";
            webRequest.Method = "POST";
            return webRequest;
        }

        static void Main(string[] args)
        {
            if(args.Length!=4)
            {
                Console.WriteLine("Usage: vatdetails username password myafm afmtocheck");
                return;
            }

            var result = Execute(args[0], args[1], args[2], args[3]);
            Console.ReadLine();
        }
    }

    public class VATResult
    {
        public string AFM { get; set; }
        public string StopDate { get; set; }
        public string PostalAddressNo { get; set; }
        public string DoyDescr { get; set; }
        public string Doy { get; set; }
        public string Onomasia { get; set; }
        public string LegalStatusDescr { get; set; }
        public string RegistDate { get; set; }
        public string DeactivationFlag { get; set; }
        public string DeactivationFlagDescr { get; set; }
        public string PostalAddress { get; set; }
        public string FirmFlagDescr { get; set; }
        public string CommerTitle { get; set; }
        public string PostalAreaDescription { get; set; }
        public string INiFlagDescr { get; set; }
        public string PostalZipCode { get; set; }
        public string FirmActDescr { get; set; }
        public string FirmActKind { get; set; }
        public string FirmActKindDescr { get; set; }
        public string FirmActCode { get; set; }
        public string ErrorDescr { get; set; }
        public string ErrorCode { get; set; }

        /// <summary>
        /// Parses the SOAP message
        /// </summary>
        /// <param name="xml">String containing the SOAP message</param>
        /// <returns>A VATResult object containing the parsed information from the SOAP message</returns>
        public static VATResult FromXMLString(string xml)
        {
            XDocument doc = XDocument.Parse(xml);
            XNamespace env = "http://schemas.xmlsoap.org/soap/envelope/";
            XNamespace m = "http://gr/gsis/rgwspublic/RgWsPublic.wsdl";
            VATResult res = new VATResult();
            XElement output = doc.Element(env + "Envelope").Element(env + "Body").Element(m + "rgWsPublicAfmMethodResponse").Element("RgWsPublicBasicRt_out");
            res.AFM = ParseElement(output.Element(m + "afm"));
            res.StopDate = ParseElement(output.Element(m + "stopDate"));
            res.PostalAddressNo  = ParseElement(output.Element(m + "postalAddressNo"));
            res.DoyDescr  = ParseElement(output.Element(m + "doyDescr"));
            res.Doy = ParseElement(output.Element(m + "doy"));
            res.Onomasia = ParseElement(output.Element(m + "onomasia"));
            res.LegalStatusDescr = ParseElement(output.Element(m + "legalStatusDescr"));
            res.RegistDate = ParseElement(output.Element(m + "registDate"));
            res.DeactivationFlag = ParseElement(output.Element(m + "deactivationFlag"));
            res.DeactivationFlagDescr = ParseElement(output.Element(m + "deactivationFlagDescr"));
            res.PostalAddress = ParseElement(output.Element(m + "postalAddress"));
            res.FirmFlagDescr = ParseElement(output.Element(m + "firmFlagDescr"));
            res.CommerTitle = ParseElement(output.Element(m + "commerTitle"));
            res.PostalAreaDescription = ParseElement(output.Element(m + "postalAreaDescription"));
            res.INiFlagDescr = ParseElement(output.Element(m + "INiFlagDescr"));
            res.PostalZipCode = ParseElement(output.Element(m + "postalZipCode"));

            XElement output2 = doc.Element(env + "Envelope").Element(env + "Body").Element(m + "rgWsPublicAfmMethodResponse").Element("arrayOfRgWsPublicFirmActRt_out").Element(m+ "RgWsPublicFirmActRtUser");
            res.FirmActCode= ParseElement(output2?.Element(m + "firmActCode")); 
            res.FirmActDescr= ParseElement(output2?.Element(m + "firmActDescr"));
            res.FirmActKind= ParseElement(output2?.Element(m + "firmActKind")); 
            res.FirmActKindDescr= ParseElement(output2?.Element(m + "firmActKindDescr")); 

            XElement outputError = doc.Element(env + "Envelope").Element(env + "Body").Element(m + "rgWsPublicAfmMethodResponse").Element("pErrorRec_out");
            res.ErrorCode = ParseElement(outputError.Element(m + "errorCode"));
            res.ErrorDescr = ParseElement(outputError.Element(m + "errorDescr"));

            return res;
        }

        private static string ParseElement(XElement element)
        {
            XNamespace xsi = "http://www.w3.org/2001/XMLSchema-instance";
            if (element?.Attribute(xsi + "nil")?.Value == "true")
                return null;
            else
                return element?.Value;
        }
    }

    
}
