# Sherlock

Sherlock reports any crash that occurres in your application as a notification. You just need to initialize Sherlock at the start of your application and it will take care of the rest. 

# Source

The code in this repository was inspired from [ajitsing/sherlock - 1.0.4](https://github.com/ajitsing/Sherlock). We are very thankful to ajitsing.

## Motivation
The motivation behind creating Sherlock is to make the life of Developer and tester easier. Whenever a tester is testing
the app and he/she encounters a crash, most of the time they don't have enough details in their hand to enable developer to
start fixing the crash immediately. Now with the help of Sherlock, any tester will have enough info to report the crash.

Screenshot
----------
![screenshot](/Screenshot/screenshot.jpg)

## Installation

I) For using Sherlock module in sample app, include the source code and add the below dependencies in entry/build.gradle to generate hap/support.har.
```
dependencies {
        implementation project(':sherlock')
        implementation project(':sherlock_no_op')
        implementation fileTree(dir: 'libs', include: ['*.har'])
        testImplementation 'junit:junit:4.13'
}
```
II) For using Sherlock in separate application using har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file.
```
dependencies {
        implementation fileTree(dir: 'libs', include: ['*.har'])
        testImplementation 'junit:junit:4.12'
}
```

Usage
-----
II). Usage in java - Sherlock library has init API:
	
	Sherlock.init(this)

Once you add ```Sherlock.init(this)``` Sherlock will take care of reporting all the crashes to you.

Support and extension
---------------------

Currently there is a limitation to 
1) to get all the crash details (Intent to CrashListActivity)
2) about device details


## Contributing
You can contribute to Sherlock by forking the repo and creating pull requests. You can also contribute by reporting bugs/issues.
If you want to see a new feature in Sherlock, just add that as an issue with enough details.

LICENSE
-------

```LICENSE
Copyright (C) 2017 Ajit Singh

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
