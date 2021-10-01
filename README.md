# Large Hitbox Pathing

Tired of >= 1.0 width entities spinning around in circles as they chase you? I was as well, so and I spent the 2 hours debugging through Pathfinding so you don't have to. 
This library introduces the `LargePathing` interface. Tag any entity class with this & enjoy the ability to use hitboxes larger than 0.99!

![](resources/example.png)

Available on [JitPack](https://jitpack.io/#Draylar/large-hitbox-pathing) and built for 1.17.1. If you want to verify I am not going crazy, load up a superflat world with this mod and summon a `test:unfixed_example_entity`. Let it chase you north and watch it spin around in circles. Spiders do this too!
