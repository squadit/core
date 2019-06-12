package com.athena.core.infrastructure.localresource

import android.content.Context
import com.athena.core.common.entity.LocalResourceModel
import com.athena.core.infrastructure.localstorage.LocalStorage
import com.athena.core.infrastructure.mapper.Mapper
import java.io.File

class ResourceManager(
    context: Context,
    private val mapper: Mapper,
    private val localStorage: LocalStorage
) {

    private val fileName = context.filesDir.path.toString() + "/LocalResource"

    fun setResources(localResourceModel: LocalResourceModel) {
        if (localResourceModel.data == null) {
            val resources = readFromFile()
            LocalResource.set(resources?.data!!)
        } else {
            LocalResource.set(localResourceModel.data)
            localStorage.storeString("LOCAL_RESOURCE_VERSION", localResourceModel.version)
            writeToFile(localResourceModel)
        }
    }

    private fun writeToFile(localResourceModel: LocalResourceModel) {
        val file = File(fileName)
        val content = mapper.convertToJsonFromObject(localResourceModel)
        content?.let {
            file.writeText(it)
        }
    }

    private fun readFromFile(): LocalResourceModel? {
        val file = File(fileName)
        val content = file.readText()
        return mapper.convertToObjectFromJson(content, LocalResourceModel::class.java)
    }
}