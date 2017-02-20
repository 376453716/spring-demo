### jdk concurrent package

1. Death lock
Node : Parent p Child c

p.addChild(c)-->
    p.addChild(c) lock p
    c.setParent(p) try lock c
    
c.setParent(p)--->
    c.setParent(p) lock c
    p.addChild(c)   tryLock p


### AQS

### util
 
 