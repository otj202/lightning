The Master does 3 things.

1. Create Function
	
	(i) Creates a docker image based on input code, cpu, memory, and environment variables along with numerous config options tbd.
	
	(ii) Creates a Kubernetes Pod with that docker image, which will mount the shared drive
	
	(iii) Creates a Deployment with that pod
	
	(iv) Creates a Horizontal Pod Autoscaler for that deployment based on cpu/memory.
	
	(v) Creates a Load Balancer for that Deployment.
	
	(vi) Adds an entry to the functions table in the db

2. Update Function
	
	(i) updates code files,env vars, cpu/memory settings on the pods corresponding to the function
	
	(ii) updates the functions table with any new config options.

3. Invoke Function
	
	(i) sends a kubernetes request to see if the func has any instances up (if we have a need for speed we can store this on the 
	db)
	
	(ii) If we don't, scale up to 1.
	
	(iii) Send an rpc request to the function pod through the load balancer
	
	(iv) updates the functions table with lastInvokedAt, any other wanted metadata/instrumentation. 
	
	(v) returns response


TODO: configure LinkerD to run in your cluster and add it to the deployment script. (we can wait on this, until we actually start spinning up load balancers...)
