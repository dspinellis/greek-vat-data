# Get details for a Greek VAT code
Example Visual Studio solution which contains a C# file that can be used to obtain VAT details from GSIS web service. 

It can be run from the command-line. Compatible with .NET Framework 4.5 and newer.

Example:
vatDetails <username> <passsword> <myVAT> 090283815

It will display the SOAP message response on screen and will return a VATResult object, containing properties with all the related information.

PS. Code has not been developed with Visual Studio's "Add Service Reference" [tool](https://msdn.microsoft.com/en-us/library/bb628652.aspx) in order to keep the code in a single file. This tool allows you to add/update a service reference via the WSDL file and its usage is highly recommended in production projects.
