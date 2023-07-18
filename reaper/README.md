The reaper does one thing. 
It queries the workers table for functions that haven't been invoked within their cold start timeout (if they have one) and scales them to 0.
