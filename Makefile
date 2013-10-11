# type 'make -s list' to see list of targets.

run-app:
	./gradlew jettyRun

test-app:
	./gradlew clean test

test-app-ci:
	./gradlew clean test

setup-app:
	git remote add functional01 git@heroku.com:filmster-core-func01.git
	git remote add qa01         git@heroku.com:filmster-core-qa01.git
	git remote add demo01       git@heroku.com:filmster-core-demo01.git
	git remote add stage01      git@heroku.com:filmster-core-stage01.git
	git remote add prod01       git@heroku.com:filmster-core-prod01.git

setup-heroku:
	heroku apps:create --remote functional01 --app filmster-core-func01
	heroku apps:create --remote qa01         --app filmster-core-qa01
	heroku apps:create --remote demo01       --app filmster-core-demo01
	heroku apps:create --remote stage01      --app filmster-core-stage01
	heroku apps:create --remote prod01       --app filmster-core-prod01
	heroku config:add APP_ENV=functional01   --app filmster-core-func01
	heroku config:add APP_ENV=qa01           --app filmster-core-qa01
	heroku config:add APP_ENV=demo01         --app filmster-core-demo01
	heroku config:add APP_ENV=stage01        --app filmster-core-stage01
	heroku config:add APP_ENV=prod01         --app filmster-core-prod01

.PHONY: no_targets__ list
no_targets__:
list:
	sh -c "$(MAKE) -p no_targets__ | awk -F':' '/^[a-zA-Z0-9][^\$$#\/\\t=]*:([^=]|$$)/ {split(\$$1,A,/ /);for(i in A)print A[i]}' | grep -v '__\$$' | sort"
