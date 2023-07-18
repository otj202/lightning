This is the master application.

It does five things.

1. Create function
We will implement it like so:
   write a create function that accepts:
    - runtime (python/js/java) 
    - function code (file with invoke() method)
    - mem sz
    - env vars
   and sends a KEDA request to spin up a worker HPA.
   It will have to store the IP of the worker HPA in a db pod
   Note: to make master autoscaling work(not to zero tho), there will also be a master db entry.
   It will provide a "lastInvokedAt" endpoint too, for KEDA to call via metrics API scaler:)
   hm. I'm wondering if we honestly even want KEDA. i think we'll have to make a custom scaling server 
   because our scaling logic is so specific. Basically, how exactly does KEDA scale down to zero?
   
OK, what kind of autoscaling do we actually want?
we want the pods to scale up based on demand(if all instances are running, & new req comes in, spin up a new one)
and down based on inactivity( if no invocations to this guy in 15 mins, kill em. )
we want the workers to scale down to zero, and the master to scale down to one. 
can KEDA do that, and is it worth using? or are we better off doing this ourselves.
honestly, no. i think we need to just do this ourselves. i mean, we could totally just use it to scale down to zero. 
is there a clever way to use it to scale up? yes, lol. we have a value called areAllInstancesRunning and set it to one if false, two if true, NEVER zero.  
ok, keda it is. 
but we are going to have to be able to (a) track what instances are running for a fucntion (b) pick one and start runing on it (c) set areAllInstancesRunning


2. Update function
3. Invoke function
4. Auto-scale workers (who auto-scales the master?KEDA.)
5. Register Nodes
