package br.com.example.taskapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import br.com.example.taskapp.databinding.FragmentRecoveryAccountBinding
import br.com.example.taskapp.helper.BaseFragment
import br.com.example.taskapp.helper.initToolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RecoveryAccountFragment : BaseFragment() {

    private var _binding: FragmentRecoveryAccountBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoveryAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)

        auth = Firebase.auth

        initClicks()
    }

    private fun initClicks() {

        binding.btnSend.setOnClickListener { validateData() }

    }

    private fun validateData() {
        val email = binding.edtEmail.text.toString().trim()

        if (email.isNotEmpty()) {

            hideKeyboard()

            binding.progressBar.isVisible = true

            recoveryAccountUser(email)

        } else {
            Toast.makeText(requireContext(), "Informe seu e-mail.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun recoveryAccountUser(email: String) {
        auth.sendPasswordResetEmail(email).addOnCompleteListener(requireActivity()) { task ->
            if (task.isSuccessful) {
                Toast.makeText(
                    requireContext(),
                    "Pronto acabamos de enviar um link para o seu e-mail",
                    Toast.LENGTH_SHORT
                ).show()
            }
//                Toast.makeText(
//                    requireContext(),
//                    "Email não encontrado. Por favor, verifique se o email esta cadastrado.",
//                    Toast.LENGTH_SHORT
//                ).show()


                binding.progressBar.isVisible = false
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}