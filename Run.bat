call mvn package
ping -n 3 localhost > Nul
call mvn cargo:redeploy
ping -n 60 localhost > Nul