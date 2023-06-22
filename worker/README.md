This is the worker application. it runs a lighting function on a kubernetes pod.

It accepts an RPC(HTTP2? easy tiger, start with rpc) request from the master and:
    - runs the function
    - returns the result
    - handles errors
