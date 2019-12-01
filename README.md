# Java Alternatives

Tool to help manage Java alternatives in Linux systems.

_!!! not implemented yet !!!_

## Goals:

1. Based on JDK's _bin_ directory 
    1. generate _update-alternatives --install_ commands to be executed 
    1. generate _.jinfo_ file
1. Support for Graal VM, Oracle and Open JDK in versions 8+.
1. Native executable (with Graal VM's native image capabilities).
1. What else would be useful?

## Usage:

### Generate _install_ commands

```bash
./bin/java-alternatives.sh install /path/to/JDK/home priority
```

For example

```bash
./bin/java-alternatives.sh install /lib/jvm/graalvm-ee-19.2.1/ 200
```

prints to STDOUT something like this

```
...
sudo update-alternatives --install /usr/bin/jarsigner jarsigner /lib/jvm/graalvm-ee-19.2.1/bin/jarsigner 200
sudo update-alternatives --install /usr/bin/java java /lib/jvm/graalvm-ee-19.2.1/bin/java 200
sudo update-alternatives --install /usr/bin/java-rmi.cgi java-rmi.cgi /lib/jvm/graalvm-ee-19.2.1/bin/java-rmi.cgi 200
sudo update-alternatives --install /usr/bin/javac javac /lib/jvm/graalvm-ee-19.2.1/bin/javac 200
sudo update-alternatives --install /usr/bin/javadoc javadoc /lib/jvm/graalvm-ee-19.2.1/bin/javadoc 200
...
```