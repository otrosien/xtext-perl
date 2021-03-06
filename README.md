[![Build Status](https://travis-ci.org/otrosien/xtext-perl.svg)](https://travis-ci.org/otrosien/xtext-perl)

# parsing perl with xtext

Only perl can parse perl? Let's see.. Demo of how much of perl can be parsed using xtext.

# What's the state?

I'm trying to closely following the parser structure from [PPI](http://search.cpan.org/~mithaldu/PPI-1.220/lib/PPI.pm).
It's still at the very beginning of implementation. So far only the following elements have parser rules:

Statements:
* subs
* package declaration
* includes (use,require,pragmas)
* labels ('LINE:')

Structure:
* blocks ('{' .... '}')

Token:
* Comments
* Reserved keywords
* Operators, file-test operators (-e...)
* Strings,numbers
* Quotelike (q,qq,qx..)
* Backticks
* Regex (s,m,tr)... 
* DATA / END
* POD
* Array-Deref (@{$...})

Known issues:

* Does not recognize regex with missing match prefix-char "m".
* Regex and quote-like delimiters limited to the most-used combinations //,||,<>,{}
* Package references in includes need to be on the project classpath in order for xtext to resolve them. This would 
  need to be extended to include searching PERL5LIB.
