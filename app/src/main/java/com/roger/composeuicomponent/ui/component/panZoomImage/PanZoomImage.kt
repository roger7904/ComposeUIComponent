package com.roger.composeuicomponent.ui.component.panZoomImage

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import com.roger.composeuicomponent.R

@Composable
fun PanZoomImageScreen(){
    Surface {
        PanZoomImage(
            painter = painterResource(id = R.drawable.ic_launcher_background),
        )
    }
}

@Composable
fun PanZoomImage(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String?="",
) {
    // Hold
    var size by remember { mutableStateOf(IntSize.Zero) }
    var scale by rememberSaveable { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    var contentScale by remember { mutableStateOf(ContentScale.FillWidth) }

    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier
            .onSizeChanged {
                size = it
                contentScale = if (size.width < size.height) ContentScale.FillWidth
                else ContentScale.FillHeight
            }
            // Recognize
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = { tapOffset ->
                        scale = if (scale > 1f) {
                            offset = Offset.Zero
                            1f
                        } else {
                            offset = Offset.Zero
                            2f
                        }
                    }
                )
            }
            .pointerInput(Unit) {
                detectTransformGestures { centroid, pan, zoom, _ ->
                    if (painter.intrinsicSize != Size.Unspecified) {
                        scale = (zoom * scale).coerceIn(1F, 3F)
                        if (scale > 1F) {
                            val scaleFactor = if (size.width < size.height)
                                size.width.toFloat() / painter.intrinsicSize.width
                            else size.height.toFloat() / painter.intrinsicSize.height

                            val currentWidth = painter.intrinsicSize.width * scaleFactor * scale
                            val currentHeight = painter.intrinsicSize.height * scaleFactor * scale
                            if (currentWidth > size.width) {
                                val x = (currentWidth - size.width) / 2F
                                offset = offset.copy(
                                    x = maxOf(-x, minOf(x, offset.x + pan.x))
                                )
                            }
                            if (currentHeight > size.height) {
                                val y = (currentHeight - size.height) / 2F
                                offset = offset.copy(
                                    y = maxOf(-y, minOf(y, offset.y + pan.y))
                                )
                            }
                        } else {
                            offset = Offset.Zero
                        }
                    }
                }
            }
            // Apply
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
                translationX = offset.x,
                translationY = offset.y
            ),
        contentScale = contentScale
    )
}