mvn clean install android:redeploy android:run
adb pull /data/data/org.pokemon/databases/Pokemon.db
chmod 755 /data/data/org.pokemon/databases/Pokemon.db
