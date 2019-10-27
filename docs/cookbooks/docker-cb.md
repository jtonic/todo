# Docker cookbook

## How to quickly run an application(script) in a container

This could be very handy when there is a need

- to run, say, a script in a new language,
- get the result,
- and then close and remove the container afterwards

## Solution

- run the following command

`docker container run -it --rm --name python3 python:3-alpine python --version`

- or, interactively run a set of python commands in python shell

`docker container run -it --rm --name python3 python:3-alpine python`

and then

```python
>>> name = "Tony"; print(f"Hello {name}")
Hello Tony
>>>
```

- or even better, run a python script file (say, script.py) from current directory

`docker container run -it --rm --name python3 --mount type=bind,source="$(pwd)/script.py",target=/script.py python:3-alpine python /script.py`

> Note: to close the python shell (and exit from the container)
>
> `ctrl + d`, or
>
> type `quit()`, or
>
> type `exit()`



- or in order to run a script (script.py) in current directory


### The benefits

- you don't need to install on the host machine the language, libraries and tools used by the script to run
- very useful in case of testing the script on multiple versions, say, python 2 or 3
- the container will be removed as soon as the script finished

### The drawbacks

- when security is involved (such as, certificates, proxies) for containerized tools, it has to be configured for these tools, this required some extra-work on dockerfile
- IDE has to have support for remote-container based application. Visual studio code has this support, but not sure about the IntelliJ Idea, Netbeans, Eclipse.

>Note: Visual Studio code has support for working with docker containerized project, benefiting all the support brought by this IDE, code completion, snippets, run, debug, intelli sense, navigation, etc.

