# Get details for a Greek VAT code
This repository aims to host diverse client programs
that obtain the details associated with a Greek VAT number,
through the
[web service](http://gsis.gr/gsis/info/gsis_site/PublicIssue/wnsp/wnsp_pages/wnsp.html)
provided by the Greek Public Revenue Authority and
the General Secretariat of Information Systems at the Greek Ministry of Finance.
Note that this project is a volunteer effort and **is not affiliated in any way** with the
data service providers at the Greek Ministry of Finance.

Details about each client are provided in the `README` file in each directory.
Currently the following clients are provided.

* Bash shell script by Diomidis Spinellis
* C# contributed by [Dimitris - Ilias Gkanatsios](http://www.dgkanatsios.com)
* Java contributed by Anastasios Zouzias
* JavaScript contributed by Anastasios Zouzias
* PHP contributed by Spiros Ioannou

Other clients (not hosted in this repo):

* [Node.js client](https://www.npmjs.com/package/afm-info)

# Contributing
Contributions in other languages (e.g. Python, Ruby, C++, client-side JavaScript) are
welcomed.
Please follow these steps to contribute a new client.

* Visit the repository's
[GitHub issues](https://github.com/dspinellis/greek-vat-data/issues)
and open a new issue describing the client you wish to contribute,
in order to avoid work duplication.
* Place your code under a separate directory (e.g. `JavaScript`).
* Add a `README.md` file describing the client's prerequisites and use.
* License the code under the
[Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)
by adding a copyright notice with your name.
(See the scripts in the `bash` directory for an example.)
* Contribute via a [GitHub pull request](https://yangsu.github.io/pull-request-tutorial/).
