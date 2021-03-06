/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.rendering.logic;

import org.terasology.entitySystem.Component;
import org.terasology.entitySystem.Owns;
import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.network.Replicate;
import org.terasology.rendering.assets.animation.MeshAnimation;
import org.terasology.rendering.assets.material.Material;
import org.terasology.rendering.assets.skeletalmesh.SkeletalMesh;
import org.terasology.rendering.nui.properties.Range;
import org.terasology.world.block.ForceBlockActive;

import javax.vecmath.Vector3f;
import java.util.Map;

/**
 * @author Immortius
 */
@ForceBlockActive
public class SkeletalMeshComponent implements Component {
    public SkeletalMesh mesh;
    public Material material;

    @Replicate
    public MeshAnimation animation;
    public boolean loop;
    public float animationRate = 1.0f;
    @Range(min = -2.5f, max = 2.5f)
    public float heightOffset;

    @Owns
    public Map<String, EntityRef> boneEntities;
    public EntityRef rootBone = EntityRef.NULL;
    public float animationTime;

    public Vector3f scale = new Vector3f(1, 1, 1);
    public Vector3f translate = new Vector3f();
}
