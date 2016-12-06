package com.giou.objparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.giou.objparse.objparser.BuilderInterface;
import com.giou.objparse.objparser.ObjectParser;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button mParse;
    private String objurl = "/mnt/sdcard/cc.obj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mParse = (Button) findViewById(R.id.btn_parse);
        initData();
    }

    private void initData() {
        mParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSlopeData(objurl);
            }
        });
    }

    private void getSlopeData(String sourceobj) {

        ObjectParser objectParser = new ObjectParser(this, new BuilderInterface() {
            @Override
            public void setObjFilename(String filename) {

            }

            /**
             *
             * @param x 时间
             * @param y 阻力
             * @param z 无用
             */
            @Override
            public void addVertexGeometric(float x, float y, float z) {
                Log.d("坐标数据","  X="+x+"  Y="+y);
            }

            @Override
            public void addVertexTexture(float u, float v) {

            }

            @Override
            public void addVertexNormal(float x, float y, float z) {

            }

            @Override
            public void addPoints(int[] values) {

            }

            @Override
            public void addLine(int[] values) {

            }

            @Override
            public void addFace(int[] vertexIndices) {

            }

            @Override
            public void addObjectName(String name) {

            }

            @Override
            public void addMapLib(String[] names) {

            }

            @Override
            public void setCurrentGroupNames(String[] names) {

            }

            @Override
            public void setCurrentSmoothingGroup(int groupNumber) {

            }

            @Override
            public void setCurrentUseMap(String name) {

            }

            @Override
            public void setCurrentUseMaterial(String name) {

            }

            @Override
            public void newMtl(String name) {

            }

            @Override
            public void setXYZ(int type, float x, float y, float z) {

            }

            @Override
            public void setRGB(int type, float r, float g, float b) {

            }

            @Override
            public void setIllum(int illumModel) {

            }

            @Override
            public void setD(boolean halo, float factor) {

            }

            @Override
            public void setNs(float exponent) {

            }

            @Override
            public void setSharpness(float value) {

            }

            @Override
            public void setNi(float opticalDensity) {

            }

            @Override
            public void setMapDecalDispBump(int type, String filename) {

            }

            @Override
            public void setRefl(int type, String filename) {

            }

            @Override
            public void doneParsingMaterial() {

            }

            @Override
            public void doneParsingObj(String filename) {

            }
        });

        try {
            objectParser.parse(sourceobj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
