import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.api.CharactersViewModel

@Composable
fun CharacterDetailsScreen(viewModel:  CharactersViewModel, characterId: Int) {
    viewModel.getCharacterById(characterId)

    Column {
        viewModel.character.value?.let { character ->
            Text(
                text = character.name,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Image(
                painter = rememberImagePainter(character.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
            )

            Text(
                text = "ID: ${character.id}",
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Species: ${character.species}",
                modifier = Modifier.padding(16.dp)
            )
            // Add other character details as necessary

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { viewModel.toggleFavourite(character) },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = if (viewModel.isFavourite(character.id)) "Remove from favourites" else "Add to favourites"
                )
            }
        }
    }
}