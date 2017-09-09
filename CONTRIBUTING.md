# Contributing to reladomo-scala

### Reporting Issues
Search the [issue tracker](https://github.com/folio-sec/reladomo-scala/issues) for relevant issues and create a new one if you don't find a match.


### Submitting Pull Request
We welcome receiving pull requests from the community! When you create a pull request, please kindly follow these guidelines:
- [Mention the GitHub issue](https://help.github.com/articles/closing-issues-using-keywords/) in your commit message when relevant.
- Pull requests should be sent to the "master" branch.
- Make sure you rebase your fork so that pull requests can be fast-forward merges.
- Your git commit must contain a `Sign-off by: Full Name <email address>` line. See below.
- New files must contain the standard Apache 2.0 header with appropriate copyright holder.
- Every file you modify should contain a single line with copyright information after the Apache header:

```
//Portions copyright <copyright holder>. Licensed under Apache 2.0 license
```

- If you're going to contribute code from other open source projects, commit that code first with comment
saying `covered by: <license>` where `<license>` is license of the code being committed. Ensure the file retains its original copyright notice and add an appropriate line to NOTICE.txt in the same commit. You can then modify that code in subsequent commits with appropriate portions copyright information.

### Sign your work

We request every contributor of `reladomo-scala` to sign Developer Certificate of Origin ("DCO") from [developercertificate.org](http://developercertificate.org/).
Please read the DCO below and certify with signing your git commit.

```
Developer Certificate of Origin
Version 1.1

Copyright (C) 2004, 2006 The Linux Foundation and its contributors.
1 Letterman Drive
Suite D4700
San Francisco, CA, 94129

Everyone is permitted to copy and distribute verbatim copies of this
license document, but changing it is not allowed.

Developer's Certificate of Origin 1.1

By making a contribution to this project, I certify that:

(a) The contribution was created in whole or in part by me and I
    have the right to submit it under the open source license
    indicated in the file; or

(b) The contribution is based upon previous work that, to the best
    of my knowledge, is covered under an appropriate open source
    license and I have the right under that license to submit that
    work with modifications, whether created in whole or in part
    by me, under the same open source license (unless I am
    permitted to submit under a different license), as indicated
    in the file; or

(c) The contribution was provided directly to me by some other
    person who certified (a), (b) or (c) and I have not modified
    it.

(d) I understand and agree that this project and the contribution
    are public and that a record of the contribution (including all
    personal information I submit with it, including my sign-off) is
    maintained indefinitely and may be redistributed consistent with
    this project or the open source license(s) involved.
```

In order to sign the DCO, make sure to set your `user.name` and `user.email` git configs,
then you can sign your commits using `git commit --signoff` or `git commit -s` that will add a line like below in your commits.

```
    Signed-off-by: Joe Smith <joe.smith@email.com>
```


That's it! Thanks for contributing to `reladomo-scala`!