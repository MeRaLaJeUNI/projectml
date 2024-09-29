package com.example.projectml.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.projectml.models.Persona
import com.example.projectml.models.Propiedad

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "personas.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_PERSONAS = "personas"
        private const val TABLE_PROPIEDADES = "propiedades"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NOMBRES = "nombres"
        private const val COLUMN_ENTIDAD = "entidad"
        private const val COLUMN_CURSO_PARALERO = "cursoYParalelo"
        private const val COLUMN_NOMBRE_PROPIEDAD = "nombre"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTablePersonas = """
            CREATE TABLE $TABLE_PERSONAS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NOMBRES TEXT,
                $COLUMN_ENTIDAD TEXT,
                $COLUMN_CURSO_PARALERO TEXT
            )
        """.trimIndent()

        val createTablePropiedades = """
            CREATE TABLE $TABLE_PROPIEDADES (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NOMBRE_PROPIEDAD TEXT
            )
        """.trimIndent()

        db.execSQL(createTablePersonas)
        db.execSQL(createTablePropiedades)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PERSONAS")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PROPIEDADES")
        onCreate(db)
    }

    fun addPersona(nombres: String, entidad: String, cursoYParalelo: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOMBRES, nombres)
            put(COLUMN_ENTIDAD, entidad)
            put(COLUMN_CURSO_PARALERO, cursoYParalelo)
        }
        val id = db.insert(TABLE_PERSONAS, null, values)
        db.close()
        return id
    }

    fun addPropiedad(nombre: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOMBRE_PROPIEDAD, nombre)
        }
        val id = db.insert(TABLE_PROPIEDADES, null, values)
        db.close()
        return id
    }

    fun getAllPersonas(): List<Persona> {
        val personas = mutableListOf<Persona>()
        val db = readableDatabase
        val cursor = db.query(TABLE_PERSONAS, null, null, null, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val persona = Persona(
                    id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    nombres = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOMBRES)),
                    entidad = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ENTIDAD)),
                    cursoYParalelo = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CURSO_PARALERO))
                )
                personas.add(persona)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return personas
    }

    fun getAllPropiedades(): List<String> {
        val propiedades = mutableListOf<String>()
        val db = readableDatabase
        val cursor = db.query(TABLE_PROPIEDADES, null, null, null, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val nombre = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOMBRE_PROPIEDAD))
                propiedades.add(nombre)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return propiedades
    }
}
