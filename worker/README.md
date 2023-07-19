This is the worker application. it runs a lighting function on a kubernetes pod.

It accepts an RPC request from the master and:
    - runs the function
    - returns the result
    - handles errors
