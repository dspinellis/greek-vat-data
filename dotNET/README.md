# Get details for a Greek VAT code
Example Visual Studio solution which contains a C# file that can be used to obtain VAT details from GSIS web service. 

It can be run from the command-line. Compatible with .NET Framework 4.5 and newer.

Example:
vatDetails <username> <passsword> <myVAT> 090283815

It will display the SOAP message response on screen and will return a VATResult object, containing properties with all the related information.
