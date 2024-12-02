package com.nparashuram.quest.athenacrisis

import android.net.Uri
import com.meta.spatial.core.Entity
import com.meta.spatial.core.Pose
import com.meta.spatial.core.Quaternion
import com.meta.spatial.core.SpatialFeature
import com.meta.spatial.core.Vector3
import com.meta.spatial.runtime.ReferenceSpace
import com.meta.spatial.runtime.SceneMaterial
import com.meta.spatial.toolkit.AppSystemActivity
import com.meta.spatial.toolkit.Material
import com.meta.spatial.toolkit.Mesh
import com.meta.spatial.toolkit.PanelRegistration
import com.meta.spatial.toolkit.Transform
import com.meta.spatial.toolkit.createPanelEntity
import com.meta.spatial.vr.VRFeature

class ImmersiveActivity : AppSystemActivity() {
    override fun registerFeatures(): List<SpatialFeature> {
        return listOf(VRFeature(this))
    }

    override fun registerPanels(): List<PanelRegistration> {
        return listOf(
            PanelRegistration(R.id.main_panel) {
                config {
                    height = 3f
                    width = 3f
                    enableLayer = true

                }
                activityClass = GameActivity()::class.java
            })
    }

    override fun onSceneReady() {
        super.onSceneReady()
        scene.setViewOrigin(0.0f, 0.0f, 0.0f)
        scene.enableHolePunching(true)
        scene.setReferenceSpace(ReferenceSpace.LOCAL_FLOOR)
//        scene.enablePassthrough(true)
        // Create entities
        Entity.create(
            listOf(
                Mesh(
                    mesh = Uri.parse("environment.glb"),
                    defaultShaderOverride = SceneMaterial.UNLIT_SHADER
                ),
                Transform(Pose(Vector3(0f, 0f, 3f), Quaternion(0f, 180f, 0f)))
            )
        )

        Entity.create(
            listOf(
                Mesh(Uri.parse("mesh://skybox")),
                Material().apply {
                    baseTextureAndroidResourceId = R.drawable.skybox
                    unlit = true
                })
        )

        Entity.createPanelEntity(
            R.id.main_panel,
            Transform(Pose(Vector3(0f, 0.7f, 2f), Quaternion(90f, 0f, 0f)))
        )

    }
}
