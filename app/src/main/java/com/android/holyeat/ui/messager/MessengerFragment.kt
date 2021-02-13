package com.android.holyeat.ui.messager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.data.model.Author
import com.android.holyeat.data.model.Message
import com.android.holyeat.databinding.MessengerFragmentBinding
import com.android.holyeat.ui.main.MainFragment
import com.bumptech.glide.Glide
import com.stfalcon.chatkit.commons.ImageLoader
import com.stfalcon.chatkit.messages.MessageInput.TypingListener
import com.stfalcon.chatkit.messages.MessagesListAdapter
import java.util.*


class MessengerFragment : Fragment() {

    private val viewModel: MessengerViewModel by viewModels()
    private val binding: MessengerFragmentBinding by viewBinding()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ((parentFragment as NavHostFragment).parentFragment as MainFragment).binding.bottomNavigationView.visibility =
            View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.messenger_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = MessengerFragmentArgs.fromBundle(requireArguments())

        binding.searchEt.text = args.data.name

        Glide.with(binding.root)
            .load(args.data.image)
            .circleCrop()
            .into(binding.photoIv)

        val user1 = Author(
            _id = args.data.year.toString(),
            _name = args.data.name,
            _avatar = args.data.image
        )
        val user2 = Author(_id = "1", _name = "Name", _avatar = args.data.image)


        val imageLoader =
            ImageLoader { imageView, url, payload ->
                Glide.with(binding.root)
                    .load(url)
                    .circleCrop()
                    .into(imageView)
            }

        val adapter: MessagesListAdapter<Message> = MessagesListAdapter<Message>("1", imageLoader)
        binding.messagesList.setAdapter(adapter)

        adapter.addToEnd(
            listOf(
                Message(
                    _id = "2",
                    _text = "fdfds",
                    _user = user1,
                    _createAt = Date(Date().time - 10000000)
                ),
                Message(
                    _id = "3",
                    _text = "erwerwefew",
                    _user = user2,
                    _createAt = Date(Date().time - 10000000)
                ),
                Message(
                    _id = "4",
                    _text = "erwerwefew",
                    _user = user1,
                    _createAt = Date(Date().time - 10000000)
                ),
                Message(
                    _id = "5",
                    _text = "erwerwefew",
                    _user = user1,
                    _createAt = Date(Date().time - 10000000)
                ),
                Message(
                    _id = "6",
                    _text = "erwerwefew",
                    _user = user2,
                    _createAt = Date(Date().time - 10000000)
                ),
                Message(
                    _id = "7",
                    _text = "erwerwefew",
                    _user = user1,
                    _createAt = Date(Date().time - 10000000)
                ),
            ), true
        )

        binding.input.setInputListener {
            adapter.addToStart(
                Message(
                    _id = "1",
                    _text = it.toString(),
                    _user = user2,
                    _createAt = Date()
                ), true
            )
            true
        }

        binding.callBtn.setOnClickListener {
            findNavController().navigate(MessengerFragmentDirections.actionMessengerFragmentToZoomCallDialogFragment())
        }
    }

}

