# SpringFramework4

GitBash Command On Window For Code Check-IN
===============================================

****  Login Your GitHub Account ************
==========================================
$ git --version
git version 2.14.2.windows.2
$git config --global jyotigahan
$ git config --global user.name
jyotigahan
$git config --global user.email "jrgahan@gmail.com"
$ git config --global user.email
jrgahan@gmail.com
$ git config --global --list
user.name=jyotigahan
user.email=jrgahan@gmail.com

**** GitBash Command For Code Check-IN From Local To Your GitHub Account ***************
=========================================================================================

$ echo "# SpringFramework4" >> README.md
$ git init
$ git add README.md  or $ git add . ( adding multiple file )
$ git status
$ git commit -m "first commit"
$ git remote add origin git@github.com:jyotigahan/SpringFramework4.git
$ git remote -v
origin  git@github.com:jyotigahan/SpringFramework4.git (fetch)
origin  git@github.com:jyotigahan/SpringFramework4.git (push)

$ git push -u origin master

Enter passphrase for key '/c/Users/JY001GA/.ssh/id_rsa':
Counting objects: 89, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (71/71), done.
Writing objects: 100% (89/89), 41.83 MiB | 199.00 KiB/s, done.
Total 89 (delta 3), reused 0 (delta 0)
remote: Resolving deltas: 100% (3/3), done.
To github.com:jyotigahan/SpringFramework4.git
   9c94f64..c680595  master -> master
Branch master set up to track remote branch master from origin.

